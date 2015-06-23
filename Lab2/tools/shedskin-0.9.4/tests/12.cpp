#include "builtin.hpp"
#include "12.hpp"

namespace __12__ {

str *const_0;


str *__name__;
__ss_bool d;
integer *a, *b, *c;



/**
class integer
*/

class_ *cl_integer;

str *integer::__repr__() {
    
    return const_0;
}

__ss_bool integer::__gt__(integer *b) {
    
    return True;
}

integer *maxi(integer *a, integer *b) {
    
    if (__gt(a, b)) {
        return a;
    }
    return b;
}

void __init() {
    const_0 = new str("integer!");

    __name__ = new str("__main__");

    cl_integer = new class_("integer");
    a = (new integer());
    b = (new integer());
    c = maxi(a, b);
    d = ___bool(__gt(a, b));
    print2(NULL,0,4, a, b, c, ___box(d));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__12__::__init);
}
