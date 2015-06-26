#ifndef __PEG_HPP
#define __PEG_HPP

using namespace __shedskin__;
namespace __peg__ {
    class Peg;
    extern str *__name__;
    extern class_ *cl_Peg;
    class Peg : public pyobj {
    /**
    Class representing a (coloured) peg on the mastermind board
    */
    public:
        __ss_int __colour;

        Peg() {}
        Peg(__ss_int colour) {
            this->__class__ = cl_Peg;
            __init__(colour);
        }
        __ss_int getColour();
        __ss_bool equals(Peg *peg);
        void *__init__(__ss_int colour);
    };
    extern __ss_int  default_0;
    void __init();
} // module namespace
#endif
