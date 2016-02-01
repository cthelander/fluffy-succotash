	.file	"program5.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rdi), %ecx     # ecx = length of array1
        movl    (%rsi), %edx     # edx = length of array2

        cmpl    %edx,   %ecx     # comapre array lengths?
        je      leneq            # the lengths are equal

        addl    %ecx,   %edx     # else return the sum of the lengths
        jmp     done

leneq:  movl    $0,     %edx     # edx = dot product
loop:   cmpl    $0,     %ecx     # at end of array
        je     done              # done with work
        subl    $1,     %ecx     # decrement counter
        addq    $4,     %rdi     # move to next element
        addq    $4,     %rsi     # move to next element
        
        movl    (%rdi), %eax     # hold on to first element of array1
        movl    (%rsi), %r8d     # hold on to first element of array2

        movl    $0,     %r9d     # calculate dot
        addl    %eax,   %r9d     # for return value
        imull   %r8d,   %r9d
        addl    %r9d,   %edx
        
        cmpl    %eax,   %r8d     # determine min/max
        jge     loop 
        movl    %eax,   (%rsi)   # switch if nessecery
        movl    %r8d,   (%rdi)
        jmp     loop


done:  movl    %edx,    %eax     # set return value
### This is where your code ends ...

	ret
