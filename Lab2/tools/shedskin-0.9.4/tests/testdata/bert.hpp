#ifndef __TESTDATA_BERT_HPP
#define __TESTDATA_BERT_HPP

using namespace __shedskin__;
namespace __testdata__ {
namespace __bert__ {

extern str *const_0;

class zeug;


extern str *__name__;


extern class_ *cl_zeug;
class zeug : public pyobj {
public:
    static __ss_int purple;


    zeug() { this->__class__ = cl_zeug; }
    static void __static__();
    __ss_int hallo(__ss_int x);
};

void __init();
str *hello(__ss_int x);

} // module namespace
} // module namespace
#endif
