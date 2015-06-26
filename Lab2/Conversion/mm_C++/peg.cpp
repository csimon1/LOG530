#include "builtin.hpp"
#include "colour.hpp"
#include "peg.hpp"

/** 
 * classe Peg : Representation d'un pion. 
 copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __peg__ {

str *__name__;
__ss_int  default_0;
class_ *cl_Peg;

/**
 * Recupere la couleur d'un pion
 * @return 
 */
__ss_int Peg::getColour() {
    return this->__colour;
}

/**
 * Verifie qu'un pion en equivaut un autre (meme couleur)
 * @param peg
 * @return 
 */
__ss_bool Peg::equals(Peg *peg) {   
    return ___bool((peg->getColour()==this->__colour));
}

/**
 * Initialisation d'un pion
 * @param colour :couleur du pion
 * @return 
 */
void *Peg::__init__(__ss_int colour) {   
    this->__colour = colour;
    return NULL;
}

/**
 * Initialisation du namespace
 */
void __init() {
    __name__ = new str("peg");
    default_0 = NULL;
    cl_Peg = new class_("Peg");
}

} // module namespace

