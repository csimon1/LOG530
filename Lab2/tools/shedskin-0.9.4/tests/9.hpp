#ifndef __9_HPP
#define __9_HPP

using namespace __shedskin__;
namespace __9__ {

class fred;


extern fred *a, *b;
extern str *__name__;


extern class_ *cl_fred;
class fred : public pyobj {
public:
    fred() { this->__class__ = cl_fred; }
    fred *__add__(fred *x);
};


} // module namespace
#endif
