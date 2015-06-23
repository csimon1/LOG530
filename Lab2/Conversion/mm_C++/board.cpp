#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "peg.hpp"
#include "board.hpp"
#include "row.hpp"
#include "colour.hpp"

namespace __board__ {


str *__name__;



/**
 copyright Sean McCarthy, license GPL v2 or later 
*/
class_ *cl_Board;

list<__row__::Row *> *Board::getRows() {
    
    return this->__board;
}

__row__::Row *Board::getRow(__ss_int rownum) {
    
    return (this->__board)->__getfast__(rownum);
}

void *Board::__init__() {
    
    this->__board = (new list<__row__::Row *>());
    return NULL;
}

void *Board::addRow(__row__::Row *row) {
    
    (this->__board)->append(row);
    return NULL;
}

void __init() {
    __name__ = new str("board");

    /**
     copyright Sean McCarthy, license GPL v2 or later 
    */
    cl_Board = new class_("Board");
}

} // module namespace

