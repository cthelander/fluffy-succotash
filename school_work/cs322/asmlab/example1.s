	.file	"example1.s"     # change this to match your filename
	.text
	.globl	f
f:
### This is where your code begins ...

###        movl    $0,     %ecx             # ecx = counter
###loop:   movl    (%rdi), %eax             # read element from array
###        cmpl    $0,     %eax             # at the end of the array
###        je      done
###        incl    %ecx
###        addq    $4,     %rdi
###        jmp     loop
###
###done:   movl    %ecx,   %eax

#        movl    (%rdi),     %ecx            # ecx will hold largest 
#loop:   movl    4(%rdi),    %eax
#        cmpl    $0,         %eax             # at the end of the array
#        je      done
#        cmpl    %eax,       %ecx
#        jnl      EAX      
#        movl    %eax,       %ecx
#EAX:    addq    $4,         %rdi
#        jmp     loop
#done:   movl    %ecx,       %eax

#        movl    $1,         %r8d            # esi will hold position 
#        movl    $1,         %r9d            # edi holds position of logest
#        movl    (%rdi),     %ecx            # ecx will hold largest 
#loop:   movl    4(%rdi),    %eax
#        incl    %r8d
#        cmpl    $0,         %eax             # at the end of the array
#        je      done
#        cmpl    %eax,       %ecx
#        jnl      EAX      
#        movl    %r8d,        %r9d
#        movl    %eax,       %ecx
#EAX:    addq    $4,         %rdi
#        jmp     loop
#done:   movl    %r9d,       %eax

        movl    $0,     %r8d             # counter
        movl    $0,     %ecx                     # ecx = sum
loop:   movl    (%rdi), %eax             # read element from array
        incl    %r8d
        cmpl    $0,     %eax             # at the end of the array
        je      done
        addl    %eax,   %ecx
        addq    $4,     %rdi
        jmp     loop

done:   movl    %ecx,   %eax
        cltd       
        idivl   %r8d

### This is where your code ends ...

	ret
