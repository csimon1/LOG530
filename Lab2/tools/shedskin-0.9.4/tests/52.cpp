#include "builtin.hpp"
#include "52.hpp"

namespace __52__ {


str *__name__;



__ss_int hoi(__ss_int a, __ss_int b, __ss_int c, __ss_int d) {
    
    print2(NULL,0,4, ___box(a), ___box(b), ___box(c), ___box(d));
    return c;
}

void __init() {
    __name__ = new str("__main__");

    hoi(1, 2, 1, 1);
    hoi(1, 2, 3, 1);
    hoi(1, 2, 3, 4);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__52__::__init);
}
