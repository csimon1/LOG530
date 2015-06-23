#ifndef __12_HPP
#define __12_HPP

using namespace __shedskin__;
namespace __12__ {

extern str *const_0;

class integer;


extern integer *a, *b, *c;
extern __ss_bool d;
extern str *__name__;


extern class_ *cl_integer;
class integer : public pyobj {
public:
    integer() { this->__class__ = cl_integer; }
    str *__repr__();
    __ss_bool __gt__(integer *b);
};

integer *maxi(integer *a, integer *b);

} // module namespace
namespace __shedskin__ { /* XXX */
template<> inline __ss_int __cmp(__12__::integer *a, __12__::integer *b) {
    if (!a) return -1;
    return (a->__gt__(b))?1:-1;
}
template<> inline __ss_bool __lt(__12__::integer *a, __12__::integer *b) {
    return b->__gt__(a);
}
}
#endif
