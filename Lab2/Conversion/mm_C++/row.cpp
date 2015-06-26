#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "peg.hpp"
#include "row.hpp"
#include "colour.hpp"

/** 
 * classe Row : Representation d'une ligne (un ensemble de pion). 
 copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __row__ {


str *__name__;
class_ *cl_Row;

/**
 * Recupere le code resultat de la ligne
 * @return 
 */
__code__::Code *Row::getResult() {  
    return this->__result;
}

/**
 * Recupere le code devinez de la ligne
 * @return 
 */
__code__::Code *Row::getGuess() {
    return this->__guess;
}

/**
 * Initialisation d'un ligne
 * Une ligne est constitue d'un code devinez + code resulat
 * @param guess
 * @param result
 * @return 
 */
void *Row::__init__(__code__::Code *guess, __code__::Code *result) {
    this->__guess = guess;
    this->__result = result;
    return NULL;
}

/**
 * Initialisation du package
 */
void __init() {
    __name__ = new str("row");
    cl_Row = new class_("Row");
}

} // module namespace

