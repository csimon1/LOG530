#include "builtin.hpp"
#include "45.hpp"

namespace __45__ {

str *const_0;


bert *y;
list<__ss_int> *z;
str *__name__;



/**
class bert
*/

class_ *cl_bert;

str *bert::__repr__() {
    
    return const_0;
}

void __init() {
    const_0 = new str("bert");

    __name__ = new str("__main__");

    cl_bert = new class_("bert");
    y = NULL;
    y = (new bert());
    if (___bool(y)) {
        print2(NULL,0,1, y);
    }
    z = NULL;
    z = (new list<__ss_int>(1,1));
    if (___bool(z)) {
        print2(NULL,0,1, z);
    }
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__45__::__init);
}
