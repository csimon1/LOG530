#!/bin/sh
# small script to genarate diff from our various conversions

cd `dirname $0`

#compare base_cpp2j with cleaned
#cleaned not ready yet
#diff -ur Conversion/mm_cpp2java_base/ Conversion/mm_cpp2java_cleaned/ > doc/cpp2j.diff

#compare base_p2j with cleaned
diff -ur Conversion/mm_p2j_base/mastermind/ Conversion/mm_p2j_cleaned/src/mastermind/ > doc/p2j.diff

#compare p2j_cleaned with cpp2j_cleaned
# cpp2j_cleaned not ready yet
#diff -ur Conversion/mm_p2j_cleaned/ Conversion/mm_cpp2java_cleaned/ > doc/p2j.diff
