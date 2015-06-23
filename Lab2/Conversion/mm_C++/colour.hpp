#ifndef __COLOUR_HPP
#define __COLOUR_HPP

using namespace __shedskin__;
namespace __colour__ {

extern str *const_0, *const_1, *const_2, *const_3, *const_4, *const_5;

class Colours;


extern str *__name__;


extern class_ *cl_Colours;
class Colours : public pyobj {
public:
    static __ss_int purple;
    static __ss_int yellow;
    static __ss_int green;
    static __ss_int numberOfColours;
    static __ss_int white;
    static __ss_int red;
    static __ss_int black;

    Colours() { this->__class__ = cl_Colours; }
    static void __static__();
};

void __init();
str *getColourName(__ss_int i);

} // module namespace
#endif
