#include "builtin.hpp"
#include "stat.hpp"
#include "sys.hpp"
#include "os/__init__.hpp"
#include "os/path.hpp"
#include "testdata/bert.hpp"

namespace __testdata__ {
namespace __bert__ {

str *const_0;


str *__name__;



/**
class zeug
*/

class_ *cl_zeug;

__ss_int zeug::hallo(__ss_int x) {
    __ss_int a;

    a = 1;
    return 1;
}

__ss_int zeug::purple;

void zeug::__static__() {
    purple = 3;
}

str *hello(__ss_int x) {
    __ss_int a;

    a = x;
    print2(NULL,0,1, ___box(a));
    return const_0;
}

void __init() {
    const_0 = new str("hello");

    __name__ = new str("bert");

    cl_zeug = new class_("zeug");
    zeug::__static__();
}

} // module namespace
} // module namespace

