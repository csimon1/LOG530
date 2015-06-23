#ifndef __24_HPP
#define __24_HPP

using namespace __shedskin__;
namespace __24__ {

class integer;
class fred;


extern integer *a;
extern str *__name__;


extern class_ *cl_integer;
class integer : public pyobj {
public:
    integer() { this->__class__ = cl_integer; }
    static void __static__();
};

extern class_ *cl_fred;
class fred : public pyobj {
public:
    fred() { this->__class__ = cl_fred; }
    integer *__add__(fred *x);
};

integer *hoei();

} // module namespace
#endif
