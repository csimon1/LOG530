#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "peg.hpp"
#include "colour.hpp"

/**
 * Class Code : Un code est un ensemble de 4 (par defaut) pions qui forme une combinaison
 * copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __code__ {

str *__name__;                      //nom de la class
class_ *cl_Code;                    //class contenue

list<__peg__::Peg *> * default_0;   //liste de pions

/**
 * On compare le code donne par rapport au code secret et genere un "Code" resultant.
 * Le code resultant est contitue de :
 *  -1 pions blanc par pion correct mais mal place.
 *  -1 pions noir par pion correct et bien place.
 * Le code resultant ne doit pas respecte les indexs 
 * @param code : code devinez
 * @return code resultat
 */
Code *Code::compare(Code *code) {
    list<__peg__::Peg *> *resultPegs;
    list<__ss_bool> *guessUsed, *secretUsed;
    __ss_bool __12, __13, __14, __15;
    __ss_int __10, __11, __4, __5, __6, __7, __8, __9, codeLength, count, i, j;

    resultPegs = (new list<__peg__::Peg *>());
    secretUsed = (new list<__ss_bool>());
    guessUsed = (new list<__ss_bool>());
    count = 0;
    codeLength = len(this->__pegList);

    FAST_FOR(i,0,codeLength,1,4,5)
        secretUsed->append(False);
        guessUsed->append(False);
    END_FOR

    /**
    Black pegs first: correct colour in correct position
    
    */

    FAST_FOR(i,0,codeLength,1,6,7)
        if (((this->__pegList)->__getfast__(i))->equals((code->getPegs())->__getfast__(i))) {
            secretUsed->__setitem__(i, True);
            guessUsed->__setitem__(i, True);
            resultPegs->append((new __peg__::Peg(__colour__::Colours::black)));
            count = (count+1);
        }
    END_FOR

    /**
    White pegs: trickier
    
    White pegs are for pegs of the correct colour, but in the wrong
    place. Each peg should only be evaluated once, hence the "used"
    lists.
    
    Condition below is a shortcut- if there were 3 blacks pegs
    then the remaining peg can't be a correct colour (think about it)
    
    */
    if ((count<(codeLength-1))) {

        FAST_FOR(i,0,codeLength,1,8,9)
            if (guessUsed->__getfast__(i)) {
                continue;
            }

            FAST_FOR(j,0,codeLength,1,10,11)
                if (((i!=j) and __NOT(secretUsed->__getfast__(j)) and __NOT(guessUsed->__getfast__(i)) and ((this->__pegList)->__getfast__(j))->equals((code->getPegs())->__getfast__(i)))) {
                    resultPegs->append((new __peg__::Peg(__colour__::Colours::white)));
                    secretUsed->__setitem__(j, True);
                    guessUsed->__setitem__(i, True);
                }
            END_FOR

        END_FOR

    }
    return (new Code(resultPegs));
}

/**
 * Retourne la liste de pions constituant le code
 * @return list<__peg__::Peg *>
 */
list<__peg__::Peg *> *Code::getPegs() {
    return this->__pegList;
}

/**
 * Fonction pour verifier qu'un Code est equivalent a un autre.
 * On verifie simplement que la couleur d'un pions est egale a un autre pour l'emplacement donne.
 * @param code
 * @return 
 */
__ss_bool Code::equals(Code *code) {
    list<__peg__::Peg *> *c1;
    __ss_int __2, __3, i;

    c1 = code->getPegs();

    FAST_FOR(i,0,4,1,2,3)
        if (__NOT((c1->__getfast__(i))->equals((this->__pegList)->__getfast__(i)))) {
            return False;
        }
    END_FOR

    return True;
}

/**
 * Genere un code aleatoire de taille codeSize
 * @param codeSize : Taille du code a genere
 * @return Code aleatoire
 */
void *Code::setRandomCode(__ss_int codeSize) {
    __ss_int __0, __1, i;
    __peg__::Peg *x;

    if ((codeSize==(-1))) {
        codeSize = this->__defaultCodeSize;
    }
    __random__::seed(((void *)(NULL)));
    this->__pegList = (new list<__peg__::Peg *>());

    FAST_FOR(i,0,codeSize,1,0,1)
        x = (new __peg__::Peg(__random__::randint(0, (__colour__::Colours::numberOfColours-1))));
        (this->__pegList)->append(x);
    END_FOR

    return NULL;
}

/**
 * Constructeur d'un code par defaut
 * @param __pegList
 * @return 
 */
void *Code::__init__(list<__peg__::Peg *> *__pegList) {
    this->__defaultCodeSize = 4;
    this->__pegList = __pegList;
    return NULL;
}

/**
 * Constructeur du namespace
 */
void __init() {
    __name__ = new str("code");
    default_0 = NULL;
    cl_Code = new class_("Code");
}

} // module namespace

