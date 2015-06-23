SHEDSKIN_LIBDIR=./lib
CC=g++
CCFLAGS=-O2 -march=native -Wno-deprecated $(CPPFLAGS) -I. -I${SHEDSKIN_LIBDIR}
LFLAGS=-lgc -lpcre $(LDFLAGS)

CPPFILES=row.cpp \
	peg.cpp \
	mastermind.cpp \
	game.cpp \
	colour.cpp \
	code.cpp \
	board.cpp \
	${SHEDSKIN_LIBDIR}/time.cpp \
	${SHEDSKIN_LIBDIR}/sys.cpp \
	${SHEDSKIN_LIBDIR}/re.cpp \
	${SHEDSKIN_LIBDIR}/random.cpp \
	${SHEDSKIN_LIBDIR}/math.cpp \
	${SHEDSKIN_LIBDIR}/builtin.cpp

HPPFILES=row.hpp \
	peg.hpp \
	mastermind.hpp \
	game.hpp \
	colour.hpp \
	code.hpp \
	board.hpp \
	${SHEDSKIN_LIBDIR}/time.hpp \
	${SHEDSKIN_LIBDIR}/sys.hpp \
	${SHEDSKIN_LIBDIR}/re.hpp \
	${SHEDSKIN_LIBDIR}/random.hpp \
	${SHEDSKIN_LIBDIR}/math.hpp \
	${SHEDSKIN_LIBDIR}/builtin.hpp

all:	mastermind

mastermind:	$(CPPFILES) $(HPPFILES)
	$(CC)  $(CCFLAGS) $(CPPFILES) $(LFLAGS) -o mastermind

mastermind_prof:	$(CPPFILES) $(HPPFILES)
	$(CC) -pg -ggdb $(CCFLAGS) $(CPPFILES) $(LFLAGS) -o mastermind_prof

mastermind_debug:	$(CPPFILES) $(HPPFILES)
	$(CC) -g -ggdb $(CCFLAGS) $(CPPFILES) $(LFLAGS) -o mastermind_debug

clean:
	rm -f mastermind mastermind_prof mastermind_debug

.PHONY: all clean

