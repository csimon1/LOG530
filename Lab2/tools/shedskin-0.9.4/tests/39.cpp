#include "builtin.hpp"
#include "os/path.hpp"
#include "os/__init__.hpp"
#include "stat.hpp"
#include "sys.hpp"
#include "testdata/bert.hpp"
#include "testdata/__init__.hpp"
#include "39.hpp"

namespace __39__ {

str *const_0;

using __testdata__::__bert__::hello;
using __testdata__::__bert__::zeug;

lambda3 a;
lambda2 l3;
lambda1 l2, l5;
set<double> *s4;
jurk *s2;
str *__name__;
set<__ss_int> *s3;
__testdata__::__bert__::zeug *kn;
lambda0 l1;


static inline double __lambda2__(double x, str *y);
static inline __ss_int __lambda0__(__ss_int x, __ss_int y);
static inline __ss_int __lambda1__(__ss_int x, __ss_int y);

static inline double __lambda2__(double x, str *y) {
    
    return 1.0;
}

static inline __ss_int __lambda0__(__ss_int x, __ss_int y) {
    
    return (x+y);
}

static inline __ss_int __lambda1__(__ss_int x, __ss_int y) {
    
    return (x-y);
}

/**
class jurk
*/

class_ *cl_jurk;

void jurk::__static__() {
}

__ss_int l4(__ss_int x, __ss_int y) {
    
    return (x*y);
}

__ss_int toepas(lambda1 l) {
    
    return l(1, 2);
}

void __init() {
    const_0 = new str("hoi");

    __name__ = new str("__main__");

    cl_jurk = new class_("jurk");
    jurk::__static__();
    __testdata__::__bert__::hello(4);
    hello(4);
    s2 = (new jurk());
    s4 = (new set<double>());
    s4->add(1.0);
    s3 = (new set<__ss_int>((new list<__ss_int>(3,1,2,3))));
    kn = (new __testdata__::__bert__::zeug());
    kn->hallo(4);
    l1 = __lambda0__;
    l2 = __lambda1__;
    l5 = l2;
    l3 = __lambda2__;
    print2(NULL,0,1, ___box(toepas(((lambda1)(l1)))));
    print2(NULL,0,1, ___box(toepas(l5)));
    print2(NULL,0,1, ___box(l3(1.0, const_0)));
    a = l4;
    a(3, 3);
    print2(NULL,0,1, ___box(toepas(((lambda1)(a)))));
}

} // module namespace

int main(int __ss_argc, char **__ss_argv) {
    __shedskin__::__init();
    __testdata__::__init();
    __stat__::__init();
    __os__::__path__::__init();
    __os__::__init();
    __sys__::__init(__ss_argc, __ss_argv);
    __testdata__::__bert__::__init();
    __shedskin__::__start(__39__::__init);
}
