#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "peg.hpp"
#include "row.hpp"
#include "colour.hpp"

namespace __row__ {


str *__name__;



/**
 copyright Sean McCarthy, license GPL v2 or later 
*/
class_ *cl_Row;

__code__::Code *Row::getResult() {
    
    return this->__result;
}

__code__::Code *Row::getGuess() {
    
    return this->__guess;
}

void *Row::__init__(__code__::Code *guess, __code__::Code *result) {
    
    this->__guess = guess;
    this->__result = result;
    return NULL;
}

void __init() {
    __name__ = new str("row");

    /**
     copyright Sean McCarthy, license GPL v2 or later 
    */
    cl_Row = new class_("Row");
}

} // module namespace

