#!/bin/bash

REVISION_NUMBER=0
REVISION_AUTHOR=1
REVISION_DATE=2
REVISION_VERSION=3

ANALYSYS_FOLDER=infovis_anal

SONAR_DB_USR=sonar
SONAR_DB_PWD=sonarpwd
SONAR_USR=infovis_analyzer
SONAR_PWD=analyzer


cd $(dirname $0) #move us into script folder
cd .. #move down from script
if [[ "$1" == "f" ]]; then 
	echo 'Deleting infovis folders for clean fetch'
	rm -rf $ANALYSYS_FOLDER 2> /dev/null
	rm infovis.svnlog.tmp_file 2> /dev/null
fi

repo=svn://svn.code.sf.net/p/ivtk/code
svn log $repo/tags 1> infovis.svnlog.tmp_file
nb_rev=0

declare -A rev
while read l; do
	
	if [[ $l == r* ]];
	then
		nb_rev=$((nb_rev+1));
		
		IFS='|' read -a arr <<< "$l"
		
		for ((i=0;i<=${#arr[@]};i++)) 
		do
			rev[$nb_rev,$i]=${arr[$i]};
		done
		
		IFS=' ' read -a arr <<< "${rev[$nb_rev,$REVISION_DATE]}"
		
		rev[$nb_rev,$REVISION_DATE]="${arr[0]}";
		rev[$nb_rev,$REVISION_VERSION]='';
		
	else
	
		if [[ $l == \'*\'. ]];
		then
			IFS="'" read -a arr_tmp <<< "$l"
			rev[$nb_rev,$REVISION_VERSION]="${arr_tmp[1]}";
			#echo rev[$nb_rev,$REVISION_VERSION] = ${rev[$nb_rev,$REVISION_VERSION]}
		else
			if [[ $l == \[maven-release-plugin\]* ]]
			then
				
				rev[$nb_rev,$REVISION_VERSION]=$(awk '{print $5}' <<< $l) 
				echo rev[$nb_rev,$REVISION_VERSION]=${rev[$nb_rev,$REVISION_VERSION]}
			fi
		fi
	fi
done < infovis.svnlog.tmp_file


#wget http://softlayer-dal.dl.sourceforge.net/project/cobertura/cobertura/2.1.1/cobertura-2.1.1-bin.tar.gz

#tar -zxvf cobertura-2.1.1-bin.tar.gz


if [[ "$1" == "f" ]]; then 
	mkdir $ANALYSYS_FOLDER
	echo checkout
	svn co $repo/tags $ANALYSYS_FOLDER
fi

cd ./$ANALYSYS_FOLDER
base_infovis=$(pwd)

for ((i=nb_rev-1;i>0;i--))
do
	cd $base_infovis

	rev_number_string=${rev[$i,$REVISION_NUMBER]}
    rev_number=${rev_number_string:1}
    rev_author=${rev[$i,$REVISION_AUTHOR]}
    rev_date=${rev[$i,$REVISION_DATE]}
	rev_vers=${rev[$i,$REVISION_VERSION]}

	if [[ -z $rev_vers ]]; then echo "rev_vers not foud, skipping"; continue; fi

	echo '  revision number -> ' $rev_number
	echo '  revision author -> ' $rev_author
	echo '  revision date   -> ' $rev_date
	echo '  revision version-> ' $rev_vers

	
	#../cobertura-2.1.1/cobertura-instruments.sh 
	#../cobertura-2.1.1/cobertura-report.sh --datafile ./cobertura_filtered.ser --destination ../report --format html ../sources/
	
	echo \
'# must be unique in a given SonarQube instance
sonar.projectKey=Infovis
# this is the name displayed in the SonarQube UI
sonar.projectName=Infovis
sonar.projectVersion='$rev_vers'
#sonar.projectDate='$rev_date' #breaking analysys atm 27/05/15

sonar.login='$SONAR_USR' 
sonar.password='$SONAR_PWD'

sonar.language=java


# Path is relative to the sonar-project.properties file. Replace "\" by "/" on Windows.
# Since SonarQube 4.2, this property is optional if sonar.modules is set. 
# If not set, SonarQube starts looking for source code from the directory containing 
# the sonar-project.properties file.
sonar.sources=src
#sonar.tests=./tests

#for DSM analysis
#sonar.binaries=binpath
 
# Encoding of the source code. Default is default system encoding
sonar.sourceEncoding=UTF-8

sonar.jdbc.url=jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&useConfigs=maxPerformance
sonar.jdbc.username='$SONAR_DB_USR'
sonar.jdbc.password='$SONAR_DB_PWD'

#too slow for analysys
#sonar.scm.provider=svn
#sonar.scm.disabled=false
#sonar.scm.enabled=true
#sonar.scm.url=scm:svn:'$repo'/trunk

#sonar.cobertura.reportPath=coverage.xml
' > ./$rev_vers/sonar-project.properties
	
	cd ./$rev_vers
	#echo "Simulate analysis for $rev_vers"
	sonar-runner
done



