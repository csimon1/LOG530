#ifndef __BOARD_HPP
#define __BOARD_HPP

using namespace __shedskin__;

namespace __row__ { /* XXX */
class Row;
}
namespace __board__ {

class Board;


extern str *__name__;


extern class_ *cl_Board;
class Board : public pyobj {
/**
Class board, a collection of rows
*/
public:
    list<__row__::Row *> *__board;

    Board() {}
    Board(int __ss_init) {
        this->__class__ = cl_Board;
        __init__();
    }
    list<__row__::Row *> *getRows();
    __row__::Row *getRow(__ss_int rownum);
    void *__init__();
    void *addRow(__row__::Row *row);
};

void __init();

} // module namespace
#endif
