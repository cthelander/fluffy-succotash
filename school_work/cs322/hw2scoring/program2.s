	.file	"program2.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rdi), %ecx     # ecx = length of array1
        movl    $0,     %edx     # sum zeros and nonezeros
loop1:  cmpl    $0,     %ecx     # at end of array?
        je      done1            # jump to next array
        subl    $1,     %ecx     # subtract 1 from length
        addq    $4,     %rdi     # move to next element
        movl    (%rdi), %eax    
        cmpl    $0,     %eax     # found zero?
        jne     loop1            # not zero
        incl    %edx             # update count
        jmp     loop1

done1:  movl    (%rsi), %ecx     # ecx = length of array2
loop2:  cmpl    $0,     %ecx     # at end of array?
        je      done2            # all done
        subl    $1,     %ecx     # subtract 1 from length
        addq    $4,     %rsi     # move to next element
        movl    (%rsi), %eax
        cmpl    $0,     %eax     # found zero?
        je      loop2            # zero
        incl    %edx             # update count 
        jmp     loop2

done2:  movl    %edx,   %eax     # set return value
### This is where your code ends ...

	ret
