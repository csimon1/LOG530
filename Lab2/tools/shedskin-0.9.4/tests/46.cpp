#include "builtin.hpp"
#include "46.hpp"

namespace __46__ {

str *const_0, *const_1;


str *__name__;



void *hoi(str *a, __ss_int b) {
    
    a;
    a = const_0;
    print2(NULL,0,1, a);
    return NULL;
}

void __init() {
    const_0 = new str("hoi");
    const_1 = __char_cache[49];;

    __name__ = new str("__main__");

    hoi(const_1, 1);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__46__::__init);
}
