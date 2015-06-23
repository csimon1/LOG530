#include "builtin.hpp"
#include "16.hpp"

namespace __16__ {


str *__name__;



/**
class integer
*/

class_ *cl_integer;

__ss_bool integer::__gt__(integer *b) {
    
    return True;
}

integer *maxi(integer *a, integer *b) {
    
    if (__gt(a, b)) {
        return a;
    }
    return b;
}

integer *qbert() {
    integer *a, *b, *c;

    a = (new integer());
    b = (new integer());
    c = maxi(a, b);
    return c;
}

void __init() {
    __name__ = new str("__main__");

    cl_integer = new class_("integer");
    qbert();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__16__::__init);
}
