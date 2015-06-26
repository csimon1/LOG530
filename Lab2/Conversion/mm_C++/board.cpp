#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "peg.hpp"
#include "board.hpp"
#include "row.hpp"
#include "colour.hpp"

/**
 * Class Board : Definit un espace de jeux. (un endroit ou poser les pions)
 * copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __board__ {

str *__name__;          //nom de la class
class_ *cl_Board;       //class contenue

/**
 * Retourne la liste de l'ensemble des lignes constituant le jeux
 * @return list<__row__::Row *>
 */
list<__row__::Row *> *Board::getRows() {
    return this->__board;
}

/**
 * Recuperation d'une ligne du jeux
 * @param rownum : index de la ligne a recupere
 * @return __row__::Row
 */
__row__::Row *Board::getRow(__ss_int rownum) {    
    return (this->__board)->__getfast__(rownum);
}

/**
 * Creation d'une table de jeux
 * @return 
 */
void *Board::__init__() { 
    this->__board = (new list<__row__::Row *>());
    return NULL;
}

/**
 * Ajout d'une ligne au jeux
 * @param row : ligne a rajoute
 * @return void
 */
void *Board::addRow(__row__::Row *row) {
    (this->__board)->append(row);
    return NULL;
}

/**
 * Initialisation du package
 */
void __init() {
    __name__ = new str("board");
    cl_Board = new class_("Board");
}

} // module namespace

