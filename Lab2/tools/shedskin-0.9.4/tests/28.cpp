#include "builtin.hpp"
#include "28.hpp"

namespace __28__ {


str *__name__;



void *propagate(list<__ss_int> *la) {
    
    print2(NULL,0,2, la, la);
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    propagate((new list<__ss_int>(1,1)));
    propagate((new list<__ss_int>(1,2)));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__28__::__init);
}
