#include "builtin.hpp"
#include "stat.hpp"
#include "sys.hpp"
#include "os/path.hpp"
#include "os/__init__.hpp"
#include "testdata/__init__.hpp"
#include "51.hpp"
#include "testdata/bert.hpp"

namespace __51__ {

str *const_0;


lambda0 l1;
str *__name__;
__testdata__::__bert__::zeug *z;
zeug *a;


static inline __ss_int __lambda0__(__ss_int x, __ss_int y);

static inline __ss_int __lambda0__(__ss_int x, __ss_int y) {
    
    return (x+y);
}

/**
class zeug
*/

class_ *cl_zeug;

str *zeug::meuk() {
    
    return const_0;
}

__ss_int hoi() {
    
    return 1;
}

void __init() {
    const_0 = __char_cache[50];;

    __name__ = new str("__main__");

    cl_zeug = new class_("zeug");
    print2(NULL,0,1, ___box(hoi()));
    a = (new zeug());
    print2(NULL,0,1, __testdata__::__bert__::hello(1));
    z = (new __testdata__::__bert__::zeug());
    z->hallo(1);
    print2(NULL,0,1, a->meuk());
    l1 = __lambda0__;
    print2(NULL,0,1, ___box(l1(1, 2)));
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
    __shedskin__::__start(__51__::__init);
}
