	.file	"program1.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rsi), %ecx     # ecx = length of array1
        movl    $0,     %edx     # for the sum
loop1:  cmpl    $0,     %ecx     # at end of array?
        je      done1            # jump to next array
        subl    $1,     %ecx     # subtract 1 from length
        addq    $4,     %rsi     # move to next element
        addl    (%rsi), %edx     # add element to sum
        jmp     loop1

done1:  movl    (%rdi), %ecx     # ecx = length of array2
loop2:  cmpl    $0,     %ecx     # at end of array?
        je      done2            # all done
        subl    $1,     %ecx     # subtract 1 from length
        addq    $4,     %rdi     # move to next element
        addl    (%rdi), %edx     # add element to sum
        jmp     loop2

done2:  movl    %edx,   %eax     #set return value
### This is where your code ends ...

	ret
