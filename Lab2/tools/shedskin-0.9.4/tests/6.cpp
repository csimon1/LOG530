#include "builtin.hpp"
#include "6.hpp"

namespace __6__ {


str *__name__;
__ss_int a;



__ss_int bla() {
    
    return 8;
}

void __init() {
    __name__ = new str("__main__");

    a = bla();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__6__::__init);
}
