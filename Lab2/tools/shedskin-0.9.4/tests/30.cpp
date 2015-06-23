#include "builtin.hpp"
#include "30.hpp"

namespace __30__ {

str *const_0, *const_1, *const_2, *const_3, *const_4, *const_5, *const_6, *const_7;


__iter<__ss_int> *__27;
list<str *> *argv;
__iter<list<__ss_int> *> *__23;
list<list<__ss_int> *> *__22, *clauses;
list<list<__ss_int> *>::for_in_loop __25;
list<__ss_int> *__26, *clause, *fixedt, *vars;
list<__ss_int>::for_in_loop __29;
str *__name__;
list<list<list<__ss_int> *> *> *occurrence;
__ss_int __24, __28, bincount, lit, nodecount, nrofvars;
list<list<str *> *> *cnf;


static inline list<list<str *> *> *list_comp_0();
static inline list<__ss_int> *list_comp_1(list<str *> *m);
static inline list<list<__ss_int> *> *list_comp_2();
static inline list<__ss_int> *list_comp_3();
static inline list<list<list<__ss_int> *> *> *list_comp_4();
static inline list<__ss_int> *list_comp_5();
static inline list<str *> *list_comp_6();
static inline list<__ss_int> *list_comp_7();
static inline list<__ss_int> *list_comp_8();
static inline __ss_int __lambda0__(__ss_int x, __ss_int y);

static inline list<list<str *> *> *list_comp_0() {
    file *__2;
    str *l;
    __ss_int __4;
    __iter<str *> *__3;
    file::for_in_loop __5;

    list<list<str *> *> *__ss_result = new list<list<str *> *>();

    __2 = (new file(argv->__getfast__(1)));
    FOR_IN(l,__2,2,4,5)
        if ((!(const_0)->__contains__(l->__getfast__(0)))) {
            __ss_result->append((l->strip())->split());
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_1(list<str *> *m) {
    list<str *>::for_in_loop __13;
    list<str *> *__10;
    __iter<str *> *__11;
    __ss_int __12;
    str *x;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __10 = m->__slice__(2, 0, (-1), 0);
    __ss_result->resize(len(__10));
    FOR_IN(x,__10,10,12,13)
        __ss_result->units[__12] = __int(x);
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_2() {
    __iter<list<str *> *> *__7;
    list<str *> *m;
    list<list<str *> *> *__6;
    __ss_int __8;
    list<list<str *> *>::for_in_loop __9;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FOR_IN(m,cnf,6,8,9)
        if (__ne(m->__getfast__(0), const_1)) {
            __ss_result->append(list_comp_1(m));
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_3() {
    __iter<list<str *> *> *__15;
    list<str *> *n;
    list<list<str *> *> *__14;
    __ss_int __16;
    list<list<str *> *>::for_in_loop __17;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FOR_IN(n,cnf,14,16,17)
        if (__eq(n->__getfast__(0), const_1)) {
            __ss_result->append(__int(n->__getfast__(2)));
        }
    END_FOR

    return __ss_result;
}

static inline list<list<list<__ss_int> *> *> *list_comp_4() {
    __iter<__ss_int> *__19;
    list<__ss_int> *__18;
    __ss_int __20, l;
    list<__ss_int>::for_in_loop __21;

    list<list<list<__ss_int> *> *> *__ss_result = new list<list<list<__ss_int> *> *>();

    __18 = (vars)->__add__(range((-nrofvars), 0));
    __ss_result->resize(len(__18));
    FOR_IN(l,__18,18,20,21)
        __ss_result->units[__20] = (new list<list<__ss_int> *>());
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_5() {
    __iter<__ss_int> *__31;
    list<__ss_int> *__30;
    __ss_int __32, var;
    list<__ss_int>::for_in_loop __33;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(vars));
    FOR_IN(var,vars,30,32,33)
        __ss_result->units[__32] = (-1);
    END_FOR

    return __ss_result;
}

static inline list<str *> *list_comp_6() {
    __iter<__ss_int> *__35;
    list<__ss_int> *__34;
    __ss_int __36, i;
    list<__ss_int>::for_in_loop __37;

    list<str *> *__ss_result = new list<str *>();

    __34 = vars->__slice__(1, 1, 0, 0);
    __ss_result->resize(len(__34));
    FOR_IN(i,__34,34,36,37)
        __ss_result->units[__36] = __str((((2*fixedt->__getfast__(i))-1)*i));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_7() {
    __iter<__ss_int> *__50;
    list<__ss_int> *__49;
    __ss_int __51, var;
    list<__ss_int>::for_in_loop __52;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(vars));
    FOR_IN(var,vars,49,51,52)
        __ss_result->units[__51] = (-1);
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_8() {
    __iter<__ss_int> *__72;
    list<__ss_int> *__71;
    __ss_int __73, var;
    list<__ss_int>::for_in_loop __74;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __71 = vars->__slice__(1, 1, 0, 0);
    FOR_IN(var,__71,71,73,74)
        if ((fixedt->__getfast__(var)==(-1))) {
            __ss_result->append(var);
        }
    END_FOR

    return __ss_result;
}

static inline __ss_int __lambda0__(__ss_int x, __ss_int y) {
    
    return ((((1024*x)*y)+x)+y);
}

__ss_int _reduce(lambda0 f, list<__ss_int> *l, __ss_int i) {
    __ss_int __0, __1, r;

    if (__NOT(___bool(l))) {
        if ((i!=(-1))) {
            return i;
        }
        print2(NULL,0,1, const_2);
    }
    if ((i!=(-1))) {
        r = f(i, l->__getfast__(0));
    }
    else {
        r = l->__getfast__(0);
    }

    FAST_FOR(i,0,(len(l)-1),1,0,1)
        r = f(r, l->__getfast__((i+1)));
    END_FOR

    return r;
}

__ss_int solve_rec() {
    __iter<__ss_int> *__39;
    list<__ss_int> *__38, *la_mods, *prop_mods;
    __ss_int __40, __42, __43, choice, var;
    list<__ss_int>::for_in_loop __41;

    nodecount = (nodecount+1);
    if ((nodecount==100)) {
        return 1;
    }
    if (__NOT((fixedt->__slice__(1, 1, 0, 0))->__contains__((-1)))) {
        print2(NULL,0,2, const_3, (const_4)->join(list_comp_6()));
        return 1;
    }
    la_mods = (new list<__ss_int>());
    var = lookahead(la_mods);
    if (__NOT(var)) {
        return backtrack(la_mods);
    }

    FOR_IN(choice,(new list<__ss_int>(2,var,(-var))),38,40,41)
        prop_mods = (new list<__ss_int>());
        if ((propagate(choice, prop_mods) and solve_rec())) {
            return 1;
        }
        backtrack(prop_mods);
    END_FOR

    return backtrack(la_mods);
}

__ss_int propagate(__ss_int lit, list<__ss_int> *mods) {
    tuple2<__ss_int, __ss_int> *__48;
    __iter<list<__ss_int> *> *__45;
    list<__ss_int> *clause;
    list<list<__ss_int> *>::for_in_loop __47;
    list<list<__ss_int> *> *__44;
    __ss_int __46, current, length, unfixed;

    current = len(mods);
    mods->append(lit);

    while (1) {
        if ((fixedt->__getfast__(__abs(lit))==(-1))) {
            fixedt->__setitem__(__abs(lit), __int(___bool((lit>0))));

            FOR_IN(clause,occurrence->__getfast__((-lit)),44,46,47)
                __48 = info(clause);
                length = __48->__getfirst__();
                unfixed = __48->__getsecond__();
                if ((length==0)) {
                    return 0;
                }
                else if ((length==1)) {
                    mods->append(unfixed);
                }
                else if ((length==2)) {
                    bincount = (bincount+1);
                }
            END_FOR

        }
        else if ((fixedt->__getfast__(__abs(lit))!=__int(___bool((lit>0))))) {
            return 0;
        }
        current = (current+1);
        if ((current==len(mods))) {
            break;
        }
        lit = mods->__getfast__(current);
    }
    return 1;
}

__ss_int lookahead(list<__ss_int> *mods) {
    __iter<__ss_int> *__54, *__58;
    list<__ss_int> *__53, *__57, *dif, *prop_mods, *score;
    __ss_int __55, __59, choice, prop, var;
    list<__ss_int>::for_in_loop __56, __60;

    dif = list_comp_7();

    FOR_IN(var,unfixed_vars(),53,55,56)
        score = (new list<__ss_int>());

        FOR_IN(choice,(new list<__ss_int>(2,var,(-var))),57,59,60)
            prop_mods = (new list<__ss_int>());
            bincount = 0;
            prop = propagate(choice, prop_mods);
            backtrack(prop_mods);
            if (__NOT(prop)) {
                if (__NOT(propagate((-choice), mods))) {
                    return 0;
                }
                break;
            }
            score->append(bincount);
        END_FOR

        dif->__setitem__(var, _reduce(__lambda0__, score, 0));
    END_FOR

    return dif->index(___max(1, 0, dif));
}

__ss_int backtrack(list<__ss_int> *mods) {
    __iter<__ss_int> *__62;
    list<__ss_int> *__61;
    __ss_int __63, lit;
    list<__ss_int>::for_in_loop __64;


    FOR_IN(lit,mods,61,63,64)
        fixedt->__setitem__(__abs(lit), (-1));
    END_FOR

    return 0;
}

tuple2<__ss_int, __ss_int> *info(list<__ss_int> *clause) {
    __iter<__ss_int> *__66;
    list<__ss_int> *__65;
    __ss_int __67, __69, __70, len, lit, unfixed;
    list<__ss_int>::for_in_loop __68;

    len = 0;
    unfixed = 0;

    FOR_IN(lit,clause,65,67,68)
        if ((fixedt->__getfast__(__abs(lit))==(-1))) {
            __69 = lit;
            __70 = (len+1);
            unfixed = __69;
            len = __70;
        }
        else if ((fixedt->__getfast__(__abs(lit))==__int(___bool((lit>0))))) {
            return (new tuple2<__ss_int, __ss_int>(2,(-1),0));
        }
    END_FOR

    return (new tuple2<__ss_int, __ss_int>(2,len,unfixed));
}

list<__ss_int> *unfixed_vars() {
    
    return list_comp_8();
}

void __init() {
    const_0 = new str("c%0\n");
    const_1 = __char_cache[112];;
    const_2 = new str("*** ERROR! *** reduce() called with empty sequence and no initial value");
    const_3 = __char_cache[118];;
    const_4 = __char_cache[32];;
    const_5 = new str("");
    const_6 = new str("testdata/uuf250-010.cnf");
    const_7 = new str("unsatisfiable");

    __name__ = new str("__main__");

    argv = (new list<str *>(2,const_5,const_6));
    cnf = list_comp_0();
    clauses = list_comp_2();
    nrofvars = (list_comp_3())->__getfast__(0);
    vars = range((nrofvars+1));
    occurrence = list_comp_4();

    FOR_IN(clause,clauses,22,24,25)

        FOR_IN(lit,clause,26,28,29)
            (occurrence->__getfast__(lit))->append(clause);
        END_FOR

    END_FOR

    fixedt = list_comp_5();
    nodecount = 0;
    if (__NOT(solve_rec())) {
        print2(NULL,0,2, const_7, ___box(nodecount));
    }
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__30__::__init);
}
