#ifndef __39_HPP
#define __39_HPP

using namespace __shedskin__;

namespace __testdata__ { /* XXX */
namespace __bert__ { /* XXX */
class zeug;
}
}
namespace __39__ {

extern str *const_0;

class jurk;

typedef __ss_int (*lambda3)(__ss_int, __ss_int);
typedef double (*lambda2)(double, str *);
typedef __ss_int (*lambda0)(__ss_int, __ss_int);
typedef __ss_int (*lambda1)(__ss_int, __ss_int);

extern jurk *s2;
extern set<__ss_int> *s3;
extern set<double> *s4;
extern __testdata__::__bert__::zeug *kn;
extern lambda2 l3;
extern lambda3 a;
extern lambda0 l1;
extern lambda1 l2, l5;
extern str *__name__;


extern class_ *cl_jurk;
class jurk : public pyobj {
public:
    jurk() { this->__class__ = cl_jurk; }
    static void __static__();
};

__ss_int l4(__ss_int x, __ss_int y);
__ss_int toepas(lambda1 l);

} // module namespace
#endif
