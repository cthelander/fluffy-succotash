	.file	"program4.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rdi), %ecx     # rcx = length of array1
        movl    (%rsi), %edx     # rdx = length of array2

        cmpl    %edx,   %ecx     # comapre array lengths?
        je      leneq            # the lengths are equal

        subl    %ecx,   %edx     # if the lengths are different
        cmpl    $0,     %edx     # if the difference in positive
        jg      done             # it is returned
        imull   $-1,    %edx     # else the difference *(-1) 
        jmp     done             # or the |difference|

leneq:  cmpl    $0,     %edx     # at end of array
        je     done              # done switching
        addq    $4,     %rdi     # move to next element
        addq    $4,     %rsi     # move to next element
        movl    (%rdi), %eax     # hold on to element of array1
        movl    (%rsi), %ecx     # hold on to element of array2
        movl    %eax,   (%rsi)   # array2 slot now holds array1 element
        movl    %ecx,   (%rdi)   # array1 slot now holds array2 element
        subl    $1,     %edx     # decrement counter
 
        jmp     leneq


done:  movl    %edx,   %eax     # set return value
### This is where your code ends ...

	ret
