#include "builtin.hpp"
#include "84.hpp"

namespace __84__ {


str *__name__;



void *solve_rec() {
    __iter<__ss_int> *__1;
    list<__ss_int> *__0, *la_mods;
    __ss_int __2, var;
    list<__ss_int>::for_in_loop __3;

    la_mods = (new list<__ss_int>(1,1));

    FOR_IN(var,la_mods,0,2,3)
        lookahead_variable(var, la_mods);
        propagate(var, la_mods, 0);
    END_FOR

    return NULL;
}

void *propagate(__ss_int lit, list<__ss_int> *mods, __ss_int bla) {
    
    return NULL;
}

void *lookahead_variable(__ss_int var, list<__ss_int> *mods) {
    
    propagate(10, mods, 0);
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    solve_rec();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__84__::__init);
}
