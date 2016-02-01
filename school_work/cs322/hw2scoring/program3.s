	.file	"program3.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rdi), %ecx     # ecx = length of array1
        movl    $0,     %edx     # move counter
        movq    %rdi,   %r10

loop1:  cmpl    $0,     %ecx     # at end of array?
        je      reset            # jump to next array
        addq    $4,     %r10     # move pointer
        subl    $1,     %ecx     # decrement counter
        jmp     loop1
 
reset:  movl    (%rdi), %ecx     # reset length
loop2:  cmpl    %edx,   %ecx     # at middle of array?
        jle     done1            # done reversing
        addq    $4,     %rdi     # move to next element
        subl    $1,     %ecx     # subtract 1 from length
        movl    (%rdi), %eax     # hold on to lower element
        movl    (%r10), %r8d     # hold on to higher element
        movl    %eax,   (%r10)   # switch low to high
        movl    %r8d,   (%rdi)   # switch high to low
        subq    $4,     %r10     # move high pointer
        incl    %edx             # increment counter
        jmp     loop2


done1:  movl    $1,   %eax     # set return value
### This is where your code ends ...

	ret
