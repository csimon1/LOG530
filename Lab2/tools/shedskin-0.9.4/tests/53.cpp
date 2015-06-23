#include "builtin.hpp"
#include "53.hpp"

namespace __53__ {

str *const_0, *const_1;


lambda0 x;
str *__name__;



void *yoyo(__ss_int a) {
    
    print2(NULL,0,2, const_0, ___box(a));
    return NULL;
}

void *yoyoyo(__ss_int b) {
    
    print2(NULL,0,2, const_1, ___box(b));
    return NULL;
}

void __init() {
    const_0 = new str("yoyo");
    const_1 = new str("yoyoyo");

    __name__ = new str("__main__");

    x = yoyo;
    x = ((lambda0)(yoyoyo));
    x(1);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__53__::__init);
}
