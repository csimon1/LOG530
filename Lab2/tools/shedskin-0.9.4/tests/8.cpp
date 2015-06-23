#include "builtin.hpp"
#include "8.hpp"

namespace __8__ {


double y;
__ss_int x;
str *__name__;



__ss_int aap(__ss_int y) {
    
    return y;
}

double hap(double y) {
    
    return y;
}

void __init() {
    __name__ = new str("__main__");

    x = aap(1);
    y = hap(1.0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__8__::__init);
}
