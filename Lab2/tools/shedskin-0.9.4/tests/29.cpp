#include "builtin.hpp"
#include "29.hpp"

namespace __29__ {

str *const_0, *const_1, *const_2, *const_3;


list<str *> *argv;
list<__ss_int> *fixedt, *vars;
str *__name__;
list<list<__ss_int> *> *clauses;
list<list<str *> *> *cnf;
__ss_int nrofvars;
list<list<list<list<__ss_int> *> *> *> *occurrence;


static inline list<list<str *> *> *list_comp_0();
static inline list<__ss_int> *list_comp_1(list<str *> *m);
static inline list<list<__ss_int> *> *list_comp_2();
static inline list<__ss_int> *list_comp_3();
static inline list<list<__ss_int> *> *list_comp_4(__ss_int v);
static inline list<list<__ss_int> *> *list_comp_5(__ss_int v);
static inline list<list<list<list<__ss_int> *> *> *> *list_comp_6();
static inline list<__ss_int> *list_comp_7();

static inline list<list<str *> *> *list_comp_0() {
    file *__0;
    __iter<str *> *__1;
    __ss_int __2;
    str *l;
    file::for_in_loop __3;

    list<list<str *> *> *__ss_result = new list<list<str *> *>();

    __0 = (new file(argv->__getfast__(1)));
    FOR_IN(l,__0,0,2,3)
        if ((!(const_0)->__contains__(l->__getfast__(0)))) {
            __ss_result->append((l->strip())->split());
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_1(list<str *> *m) {
    list<str *>::for_in_loop __11;
    list<str *> *__8;
    str *x;
    __ss_int __10;
    __iter<str *> *__9;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __8 = m->__slice__(2, 0, (-1), 0);
    __ss_result->resize(len(__8));
    FOR_IN(x,__8,8,10,11)
        __ss_result->units[__10] = __int(x);
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_2() {
    __iter<list<str *> *> *__5;
    list<str *> *m;
    list<list<str *> *> *__4;
    __ss_int __6;
    list<list<str *> *>::for_in_loop __7;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FOR_IN(m,cnf,4,6,7)
        if (__ne(m->__getfast__(0), const_1)) {
            __ss_result->append(list_comp_1(m));
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_3() {
    __iter<list<str *> *> *__13;
    list<str *> *n;
    list<list<str *> *> *__12;
    __ss_int __14;
    list<list<str *> *>::for_in_loop __15;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FOR_IN(n,cnf,12,14,15)
        if (__eq(n->__getfast__(0), const_1)) {
            __ss_result->append(__int(n->__getfast__(2)));
        }
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_4(__ss_int v) {
    list<__ss_int> *c;
    __ss_int __22;
    __iter<list<__ss_int> *> *__21;
    list<list<__ss_int> *>::for_in_loop __23;
    list<list<__ss_int> *> *__20;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FOR_IN(c,clauses,20,22,23)
        if ((c)->__contains__((-v))) {
            __ss_result->append(c);
        }
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_5(__ss_int v) {
    list<__ss_int> *c;
    __ss_int __26;
    __iter<list<__ss_int> *> *__25;
    list<list<__ss_int> *>::for_in_loop __27;
    list<list<__ss_int> *> *__24;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FOR_IN(c,clauses,24,26,27)
        if ((c)->__contains__(v)) {
            __ss_result->append(c);
        }
    END_FOR

    return __ss_result;
}

static inline list<list<list<list<__ss_int> *> *> *> *list_comp_6() {
    __iter<__ss_int> *__17;
    list<__ss_int> *__16;
    __ss_int __18, v;
    list<__ss_int>::for_in_loop __19;

    list<list<list<list<__ss_int> *> *> *> *__ss_result = new list<list<list<list<__ss_int> *> *> *>();

    __ss_result->resize(len(vars));
    FOR_IN(v,vars,16,18,19)
        __ss_result->units[__18] = (new list<list<list<__ss_int> *> *>(2,list_comp_4(v),list_comp_5(v)));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_7() {
    __iter<__ss_int> *__29;
    list<__ss_int> *__28;
    __ss_int __30, var;
    list<__ss_int>::for_in_loop __31;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(vars));
    FOR_IN(var,vars,28,30,31)
        __ss_result->units[__30] = (-1);
    END_FOR

    return __ss_result;
}

void __init() {
    const_0 = new str("c%0\n");
    const_1 = __char_cache[112];;
    const_2 = new str("");
    const_3 = new str("testdata/uuf250-010.cnf");

    __name__ = new str("__main__");

    argv = (new list<str *>(2,const_2,const_3));
    cnf = list_comp_0();
    clauses = list_comp_2();
    nrofvars = (list_comp_3())->__getfast__(0);
    vars = range((nrofvars+1));
    occurrence = list_comp_6();
    fixedt = list_comp_7();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__29__::__init);
}
