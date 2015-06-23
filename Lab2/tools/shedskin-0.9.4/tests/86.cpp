#include "builtin.hpp"
#include "86.hpp"

namespace __86__ {

str *const_0, *const_1;


list<str *> *s;
list<__ss_int> *numbers, *numberscopy;
str *__name__;



list<str *> *row_perm_rec() {
    list<str *> *a, *hoppa_row, *new_row;

    hoppa_row = (new list<str *>());
    new_row = (new list<str *>(1,const_0));
    a = hoppa_row;
    new_row->extend(a);
    hoppa_row = new_row->__slice__(0, 0, 0, 0);
    hoppa_row->append(const_1);
    return hoppa_row;
}

void __init() {
    const_0 = new str("");
    const_1 = __char_cache[117];;

    __name__ = new str("__main__");

    numbers = (new list<__ss_int>(1,1));
    numberscopy = numbers->__slice__(0, 0, 0, 0);
    s = row_perm_rec();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__86__::__init);
}
