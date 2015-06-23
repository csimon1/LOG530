#include "builtin.hpp"
#include "33.hpp"

namespace __33__ {

str *const_0;


str *__name__, *a;
__ss_int b;



void __init() {
    const_0 = new str("hoi");

    __name__ = new str("__main__");

    b = 1;
    a = const_0;
    print2(NULL,0,1, a);
    print2(NULL,0,1, ___box(b));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__33__::__init);
}
