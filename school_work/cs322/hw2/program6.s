	.file	"program6.s"
        .text
	.globl	f
f:

### This is where your code begins ...

        movl    (%rdi),  %ecx     # ecx = length of array1
        movq    %rdi,    %r11     # current pointer to array1
 
        cmpl    $0,      %ecx     # at end of array
        je      array2

        addq    $4,      %r11     # move r11 to first element of array1
        movl    (%r11),  %eax     # hold on to first element of array1

loop1:  cmpl    $1,      %ecx     # at end of array
        je      array2            # done switching

        movl    4(%r11), %r8d     # get the next element
        movl    %r8d,    (%r11)   # put it in current slot
        addq    $4,      %r11     # move to next element
        subl    $1,      %ecx     # decrement counter
        jmp     loop1

array2: movl    (%rsi),  %ecx     # ecx = length of array2
        movq    %rsi,    %r9      # current pointer to array2

        cmpl    $0,      %ecx     # is array 2 empty
        je      noar2             # array 2 is empty
        
        addq    $4,      %r9      # move r9 to first element of array2
        movl    (%r9),   %edx     # hold on to first element of array2

loop2:  cmpl    $1,      %ecx     # at end of array
        je      out               # done switching
 
        movl    4(%r9),  %r8d     # get next element
        movl    %r8d,    (%r9)    # put it in the current slot
        addq    $4,      %r9      # move to next element
        subl    $1,      %ecx     # decrement counter
        jmp     loop2
 
out:    cmpl    $0,      (%rdi)   # length of array1 = 0?
        je      noar1

        movl    %eax,    (%r9)    # neither array is empty
        movl    %edx,    (%r11)   # so switch first elements to ends
        jmp     done

noar1:  movl    %edx,    (%r9)    # length of array1 = 0
        jmp     done

noar2:  cmpl    $0,      (%rdi)   # length of array1 = 0?
        je      done

        movl    %eax,    (%r11)   # length of array2 = 0
        jmp     done

done:  movl     (%rdi),  %eax     
       addl     (%rsi),  %eax     # set return value
### This is where your code ends ...

	ret
