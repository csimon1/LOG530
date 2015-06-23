#ifndef __16_HPP
#define __16_HPP

using namespace __shedskin__;
namespace __16__ {

class integer;


extern str *__name__;


extern class_ *cl_integer;
class integer : public pyobj {
public:
    integer() { this->__class__ = cl_integer; }
    __ss_bool __gt__(integer *b);
};

integer *maxi(integer *a, integer *b);
integer *qbert();

} // module namespace
namespace __shedskin__ { /* XXX */
template<> inline __ss_int __cmp(__16__::integer *a, __16__::integer *b) {
    if (!a) return -1;
    return (a->__gt__(b))?1:-1;
}
template<> inline __ss_bool __lt(__16__::integer *a, __16__::integer *b) {
    return b->__gt__(a);
}
}
#endif
