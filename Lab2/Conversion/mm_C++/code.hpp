#ifndef __CODE_HPP
#define __CODE_HPP

using namespace __shedskin__;

namespace __peg__ { /* XXX */
class Peg;
}
namespace __code__ {

class Code;


extern str *__name__;


extern class_ *cl_Code;
class Code : public pyobj {
/**
Class representing a collection of pegs
*/
public:
    __ss_int __defaultCodeSize;
    list<__peg__::Peg *> *__pegList;

    Code() {}
    Code(list<__peg__::Peg *> *__pegList) {
        this->__class__ = cl_Code;
        __init__(__pegList);
    }
    Code *compare(Code *code);
    list<__peg__::Peg *> *getPegs();
    __ss_bool equals(Code *code);
    void *setRandomCode(__ss_int codeSize);
    void *__init__(list<__peg__::Peg *> *__pegList);
};

extern list<__peg__::Peg *> * default_0;

void __init();

} // module namespace
#endif
