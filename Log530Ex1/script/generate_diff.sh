#!/bin/sh

cd `dirname $0`
cd ..
git diff 5233a176ecbf72511e25d6383872c334fa5d6280 cbdff5f1a62da28df08d77e91322c2809a5757b0 -- src > ./doc/refact_by_exp.diff
