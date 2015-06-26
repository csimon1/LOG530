#include "builtin.hpp"
#include "colour.hpp"


/**
 * Class Colours : Association d'une couleur a un chiffre pour facilite les comparaison
 * copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __colour__ {

str *const_0, *const_1, *const_2, *const_3, *const_4, *const_5; //nom des differentes couleurs
str *__name__;                                                  //nom de la class

/**
 * Retourne le nom d'une couleur pour un index donnee
 * @param i
 * @return 
 */
str *getColourName(__ss_int i) {
    
    if ((i==0)) {
        return const_0;
    }
    else if ((i==1)) {
        return const_1;
    }
    else if ((i==2)) {
        return const_2;
    }
    else if ((i==3)) {
        return const_3;
    }
    else if ((i==4)) {
        return const_4;
    }
    else if ((i==5)) {
        return const_5;
    }
    return 0;
}

/**
class Colours
*/

class_ *cl_Colours;

__ss_int Colours::purple;
__ss_int Colours::yellow;
__ss_int Colours::green;
__ss_int Colours::numberOfColours;
__ss_int Colours::white;
__ss_int Colours::red;
__ss_int Colours::black;

/**
 * Constructeur des couleur
 */
void Colours::__static__() {
    numberOfColours = 6;
    red = 0;
    green = 1;
    purple = 2;
    yellow = 3;
    white = 4;
    black = 5;
}

/**
 * Constructeur du package
 */
void __init() {
    const_0 = new str("red");
    const_1 = new str("green");
    const_2 = new str("purple");
    const_3 = new str("yellow");
    const_4 = new str("white");
    const_5 = new str("black");
    __name__ = new str("colour");

    cl_Colours = new class_("Colours");
    Colours::__static__();
}

} // module namespace

