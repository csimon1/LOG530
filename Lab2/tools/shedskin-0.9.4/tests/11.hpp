#ifndef __11_HPP
#define __11_HPP

using namespace __shedskin__;
namespace __11__ {

class fred;


extern __ss_int b;
extern fred *a;
extern str *__name__;


extern class_ *cl_fred;
class fred : public pyobj {
public:
    __ss_int _a;

    fred() { this->__class__ = cl_fred; }
    void *huh();
};


} // module namespace
#endif
