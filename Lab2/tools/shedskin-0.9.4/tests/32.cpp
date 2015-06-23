#include "builtin.hpp"
#include "32.hpp"

namespace __32__ {


str *__name__;
__ss_int a, b;



void *qbert(__ss_int a) {
    
    print2(NULL,0,1, ___box(a));
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    a = 1;
    b = 2;
    qbert(1);
    qbert(2);
    qbert(a);
    qbert(b);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__32__::__init);
}
