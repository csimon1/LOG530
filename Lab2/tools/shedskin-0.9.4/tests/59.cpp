#include "builtin.hpp"
#include "59.hpp"

namespace __59__ {

str *const_0, *const_1, *const_2, *const_3;


str *__name__;



void __init() {
    const_0 = new str("hoi %d %s");
    const_1 = __char_cache[51];;
    const_2 = new str("foo\000bar", 7);
    const_3 = new str("foo\000baz", 7);

    __name__ = new str("__main__");

    print2(NULL,0,1, __modct(const_0, 2, ___box(2), const_1));
    print2(NULL,0,1, ___box(___bool(__ne(const_2, const_3))));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__59__::__init);
}
