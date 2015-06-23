#ifndef __ROW_HPP
#define __ROW_HPP

using namespace __shedskin__;

namespace __code__ { /* XXX */
class Code;
}
namespace __row__ {

class Row;


extern str *__name__;


extern class_ *cl_Row;
class Row : public pyobj {
/**
Class containing a guess code and answer code
*/
public:
    __code__::Code *__result;
    __code__::Code *__guess;

    Row() {}
    Row(__code__::Code *guess, __code__::Code *result) {
        this->__class__ = cl_Row;
        __init__(guess, result);
    }
    __code__::Code *getResult();
    __code__::Code *getGuess();
    void *__init__(__code__::Code *guess, __code__::Code *result);
};

void __init();

} // module namespace
#endif
