#include "builtin.hpp"
#include "colour.hpp"
#include "peg.hpp"

namespace __peg__ {


str *__name__;


__ss_int  default_0;


/**
 copyright Sean McCarthy, license GPL v2 or later 
*/
class_ *cl_Peg;

__ss_int Peg::getColour() {
    
    return this->__colour;
}

__ss_bool Peg::equals(Peg *peg) {
    
    return ___bool((peg->getColour()==this->__colour));
}

void *Peg::__init__(__ss_int colour) {
    
    this->__colour = colour;
    return NULL;
}

void __init() {
    __name__ = new str("peg");

    /**
     copyright Sean McCarthy, license GPL v2 or later 
    */
    default_0 = NULL;
    cl_Peg = new class_("Peg");
}

} // module namespace

