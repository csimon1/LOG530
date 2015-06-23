#include "builtin.hpp"
#include "0.hpp"

namespace __0__ {


str *__name__;
__ss_int a;



void __init() {
    __name__ = new str("__main__");

    a = 1;
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__0__::__init);
}
