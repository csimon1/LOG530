#!/bin/sh
# small script to genarate diff from our various conversions

cd `dirname $0`

#compare base_cpp2j with cleaned
diff -ur Conversion/mm_cpp2java_base/src/ Conversion/mm_cpp2java_cleaned/src/mastermind/ > doc/cpp2j.diff

#compare base_p2j with cleaned
diff -ur Conversion/mm_p2j_base/mastermind/ Conversion/mm_p2j_cleaned/src/mastermind/ > doc/p2j.diff

#compare p2j_cleaned with cpp2j_cleaned
diff -ur Conversion/mm_p2j_cleaned/src/ Conversion/mm_cpp2java_cleaned/src/mastermind/ > doc/cleaned.diff

#create diff for partie2
diff -ur Partie2/base Partie2/refact > doc/partie2.diff
