#include "builtin.hpp"
#include "7.hpp"

namespace __7__ {

str *const_0;


str *__name__, *a;



str *bwa() {
    str *d;

    d = const_0;
    return d;
}

void __init() {
    const_0 = new str("hoi");

    __name__ = new str("__main__");

    a = bwa();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__7__::__init);
}
