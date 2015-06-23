#include "builtin.hpp"
#include "79.hpp"

namespace __79__ {


list<__ss_int> *vars;
__ss_int nrofvars;
str *__name__;



void __init() {
    __name__ = new str("__main__");

    nrofvars = ((new list<__ss_int>(1,1)))->__getfast__(0);
    vars = range((nrofvars+1));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__79__::__init);
}
