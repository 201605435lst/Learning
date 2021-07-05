# [1.C# 温故而知新：Stream篇（—）](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html)

C# 温故而知新：Stream篇（—）

 目录：

[什么是Stream](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no1)?

[什么是字节序列](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no2)？

[Stream的构造函数](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no3)

[Stream的重要属性及方法](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no4)

[Stream的示例](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no5)

[Stream异步读写](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no6)

Stream 和其子类的类图

[本章总结](https://www.cnblogs.com/JimmyZheng/archive/2012/03/17/2402814.html#no8)

 

 

 

**什么是Stream?**

MSDN 中的解释太简洁了: 提供字节序列的一般视图

（我可不想这么理解，这必定让我抓狂，我理解的流是向自然界的河流那样清澈而又美丽，c#中的流也是一样，许多技术或者说核心技术都需要流的帮忙）

**那什么是字节序列呢？**

其实简单的来理解的话字节序列指的是:

字节对象都被存储为连续的字节序列，字节按照一定的顺序进行排序组成了字节序列

那什么关于流的解释可以抽象为下列情况：

打个比方：一条河中有一条鱼游过，这个鱼就是一个字节，这个字节包括鱼的眼睛，嘴巴，等组成8个二进制，显然这条河就是我们的核心对象：流

**马上进入正题，让我们来解释下c#****的 Stream** **是如何使用的**

让我们直接温故或学习下Stream类的结构，属性和相关方法

首先是构造函数

Stream 类有一个protected 类型的构造函数, 但是它是个抽象类，无法直接如下使用

```
   Stream stream = new Stream();
```

所以我们自定义一个流继承自Stream 看看哪些属性必须重写或自定义:

![img](https://images.cnblogs.com/OutliningIndicators/ContractedBlock.gif)View Code

可以看出系统自动帮我们实现了Stream 的抽象属性和属性方法

  1: CanRead: 只读属性，判断该流是否能够读取：

  2: CanSeek: 只读属性，判断该流是否支持跟踪查找

  3: CanWrite: 只读属性，判断当前流是否可写

*4: void Flush():这点必须说得仔细些:

  当我们使用流写文件时，数据流会先进入到缓冲区中，而不会立刻写入文件，当执行这个方法后，缓冲区的数据流会立即注入基础流

   MSDN中的描述：使用此方法将所有信息从基础缓冲区移动到其目标或清除缓冲区，或者同时执行这两种操作。根据对象的状态，可能需要修

   改流内的当前位置（例如，在基础流支持查找的情况下即如此）当使用 [StreamWriter](http://msdn.microsoft.com/zh-cn/library/system.io.streamwriter.aspx) 或 [BinaryWriter](http://msdn.microsoft.com/zh-cn/library/system.io.binarywriter.aspx) 类时，不要刷新 [Stream](http://msdn.microsoft.com/zh-cn/library/system.io.stream.aspx) 基对象。

   而应使用该类的 **Flush** 或 [Close](http://msdn.microsoft.com/zh-cn/library/system.io.stream.close.aspx) 方法，此方法确保首先将该数据刷新至基础流，然后再将其写入文件。

（红色部分为关键请大家务必能够理解，今后会在相应的章节中介绍）

 5: Length:表示流的长度

*6: Position属性：（非常重要）

虽然从字面中可以看出这个Position属性只是标示了流中的一个位置而已，可是我们在实际开发中会发现这个想法会非常的幼稚，

很多asp.net项目中文件或图片上传中很多朋友会经历过这样一个痛苦：Stream对象被缓存了，导致了Position属性在流中无法

找到正确的位置，这点会让人抓狂，其实解决这个问题很简单，聪明的你肯定想到了，其实我们每次使用流前必须将Stream.Position

设置成0就行了，但是这还不能根本上解决问题，最好的方法就是用Using语句将流对象包裹起来，用完后关闭回收即可。

*7: abstract int Read(byte[] buffer, int offset, int count)

这个方法包含了3个关键的参数：缓冲字节数组，位移偏量和读取字节个数，每次读取一个字节后会返回一个缓冲区中的总字节数

第一个参数：这个数组相当于一个空盒子，Read（）方法每次读取流中的一个字节将其放进这个空盒子中。（全部读完后便可使用buffer字节数组了）

第二个参数：表示位移偏量，告诉我们从流中哪个位置（偏移量）开始读取。

最后一个参数：就是读取多少字节数。

返回值便是总共读取了多少字节数.

*8: abstract long Seek(long offset, SeekOrigin origin)

  大家还记得Position属性么？其实Seek方法就是重新设定流中的一个位置，在说明offset参数作用之前大家先来了解下SeekOrigin这个枚举：

![img](https://pic002.cnblogs.com/images/2012/132191/2012031700330037.png)

如果 offset 为负，则要求新位置位于 origin 指定的位置之前，其间隔相差 offset 指定的字节数。如果 offset 为零 (0)，则要求新位置位于由 origin 指定的位置处。

如果 offset 为正，则要求新位置位于 origin 指定的位置之后，其间隔相差 offset 指定的字节数.

Stream. Seek(-3,Origin.End); 表示在流末端往前数第3个位置

Stream. Seek(0,Origin.Begin); 表示在流的开头位置

Stream. Seek(3,Orig`in.Current); 表示在流的当前位置往后数第三个位置

查找之后会返回一个流中的一个新位置。其实说道这大家就能理解Seek方法的精妙之处了吧

*9: abstract void Write(byte[] buffer,int offset,int count)

这个方法包含了3个关键的参数：缓冲字节数组，位移偏量和读取字节个数

和read方法不同的是 write方法中的第一个参数buffer已经有了许多byte类型

的数据，我们只需通过设置 offset和count来将buffer中的数据写入流中

*10: virtual void Close()

关闭流并释放资源，在实际操作中，如果不用using的话，别忘了使用完流之后将其关闭

这个方法特别重要，使用完当前流千万别忘记关闭！

 

为了让大家能够快速理解和消化上述属性和方法我会写个示例并且关键部分会详细说明

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
    static void Main(string[] args)
        {
            byte[] buffer = null;

            string testString = "Stream!Hello world";
            char[] readCharArray = null;
            byte[] readBuffer = null;
            string readString = string.Empty;
            //关于MemoryStream 我会在后续章节详细阐述
            using (MemoryStream stream = new MemoryStream()) 
            {
                Console.WriteLine("初始字符串为：{0}", testString);
                //如果该流可写
                if (stream.CanWrite)
                {
                    //首先我们尝试将testString写入流中
                    //关于Encoding我会在另一篇文章中详细说明，暂且通过它实现string->byte[]的转换
                    buffer = Encoding.Default.GetBytes(testString);
                    //我们从该数组的第一个位置开始写，长度为3，写完之后 stream中便有了数据
                    //对于新手来说很难理解的就是数据是什么时候写入到流中，在冗长的项目代码面前，我碰见过很
                    //多新手都会有这种经历，我希望能够用如此简单的代码让新手或者老手们在温故下基础
                    stream.Write(buffer, 0,3);

                    Console.WriteLine("现在Stream.Postion在第{0}位置",stream.Position+1);

                    //从刚才结束的位置（当前位置）往后移3位，到第7位
                    long newPositionInStream =stream.CanSeek? stream.Seek(3, SeekOrigin.Current):0;

                    Console.WriteLine("重新定位后Stream.Postion在第{0}位置", newPositionInStream+1);
                    if (newPositionInStream < buffer.Length)
                    {
                        //将从新位置（第7位）一直写到buffer的末尾，注意下stream已经写入了3个数据“Str”
                        stream.Write(buffer, (int)newPositionInStream, buffer.Length - (int)newPositionInStream);
                    }

                    
                    //写完后将stream的Position属性设置成0，开始读流中的数据
                    stream.Position = 0;

                    // 设置一个空的盒子来接收流中的数据，长度根据stream的长度来决定
                    readBuffer = new byte[stream.Length];


                    //设置stream总的读取数量 ，
                    //注意！这时候流已经把数据读到了readBuffer中
                    int count = stream.CanRead?stream.Read(readBuffer, 0, readBuffer.Length):0;
         

                    //由于刚开始时我们使用加密Encoding的方式,所以我们必须解密将readBuffer转化成Char数组，这样才能重新拼接成string

                    //首先通过流读出的readBuffer的数据求出从相应Char的数量
                    int charCount = Encoding.Default.GetCharCount(readBuffer, 0, count);
                    //通过该Char的数量 设定一个新的readCharArray数组
                    readCharArray = new char[charCount];
                    //Encoding 类的强悍之处就是不仅包含加密的方法，甚至将解密者都能创建出来（GetDecoder()），
                    //解密者便会将readCharArray填充（通过GetChars方法，把readBuffer 逐个转化将byte转化成char，并且按一致顺序填充到readCharArray中）
                    Encoding.Default.GetDecoder().GetChars(readBuffer, 0, count, readCharArray, 0);
                    for (int i = 0; i < readCharArray.Length; i++)
                    {
                        readString += readCharArray[i];
                    }
                    Console.WriteLine("读取的字符串为：{0}", readString);
                }

                stream.Close();
            }

            Console.ReadLine();

        }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)


显示结果：

![img](https://pic002.cnblogs.com/images/2012/132191/2012031702400770.png)

大家需要特别注意的是stream.Positon这个很神奇的属性，在复杂的程序中，往往流对象操作也会很复杂，

一定要切记将stream.Positon设置在你所需要的正确位置，还有就是 using语句的使用，它会自动销毁stream对象，

当然Stream.Close()大家都懂的

 

接着让我们来说下关于流中怎么实现异步操作

在Stream基类中还有几个关键方法,它们能够很好实现异步的读写，

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
异步读取
public virtual IAsyncResult BeginRead(byte[] buffer,int offset,int count,AsyncCallback callback,Object state)
异步写
public virtual IAsyncResult BeginWrite( byte[] buffer, int offset, int count, AsyncCallback callback, Object state )
结束异步读取
public virtual int EndRead( IAsyncResult asyncResult ) 
结束异步写
public virtual void EndWrite( IAsyncResult asyncResult )  
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

大家很容易的就能发现前两个方法实现了IAsyncResult接口，后2个end方法也顺应带上了一个IAsyncResult参数，

其实并不复杂，(必须说明下 每次调用 Begin方法时都必须调用一次 相对应的end方法)

和一般同步read或write方法一致的是，他们可以当做同步方法使用，但是在复杂的情况下可能也难逃阻塞崩溃等等，但是一旦启用了

异步之后，这些类似于阻塞问题会不复存在，可见微软对于异步的支持正在加大。

 

 最后是有关c#中Stream类和其子类的类图

 类图呢？大家肯定会这么想把 ^^

  为什么这个在目录中是灰色的？其实我个人觉得这个类图不应该放在这篇博文中，原因是我们真正理解并熟练操作了Stream的所有子类？（大牛除外）

 （这也是我写后续文章的动力之一，写博能很好的提升知识点的吸收，不仅能帮助别人，也能提高自己的对于知识点的理解），所以我想把类图放在这

  个系类的总结篇中

 

本章总结：

本章介绍了流的基本概念和c#中关于流的基类Stream所包含的一些重要的属性和方法，关键是一些方法和属性的细节和我们操作流对象时必须注意的事项，

# 2.C# 温故而知新：Stream篇（**二**）

TextReader 和StreamReader

目录：

[为什么要介绍 TextReader？](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no1)

[TextReader的常用属性和方法](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no2)

[TextReader 示例](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no11)

[从StreamReader想到多态](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no4)

[简单介绍下Encoding 编码](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no5)

[StreamReader 的定义及作用](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no6)

[StreamReader 类的常用方法属性](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no7)

[StreamReader示例](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no13)

[本章总结](https://www.cnblogs.com/JimmyZheng/archive/2012/03/19/2405216.html#no14)

 

 

 

为什么要介绍 TextReader？

首先让我们来理解下什么是TextReader，从字面上的意思入手的话，大家就会恍然大悟了

一个对于Text的读取器，可是又是怎么读取的呢？聪明的你肯定会想到，当然是通过连续

的字符进行读取， 为什么在介绍StreamReader之前，要搞这个东东？ 答案其实很简单：他们

两个就是父子关系，要了解StreamReader最好先了解他的父亲，请允许我对他们进行下简单介绍： 

 

TextReader的常用属性和方法:

我们闭上眼可以想象一下 Text这个词的范围，它囊括了许多的文件类型，我们可以在记事本上

使用任何语言(英语，中文，c# ,天书，javascript,jquery,xml,xaml,sql,c++……)，如此多

的语言文本归根结底还是通过一个个char组成的，所以微软构造出了TextReader这个抽象类对于

读取text的一系列操作，同样对于TextReader我们无法直接实例化，应为它是个抽象类，只有

定义类的行为，不针对特定实现。那好吧，看看 TextReader定义了哪些类的行为:

1:具有一个protected类型的构造函数

*2: void Close()方法：和上篇Stream一样，TextReader也有Close方法，我们必须牢记，

在用完之后应该主动关闭它

*3: void Dispose()方法：释放所有该TextReader 所持有的所有资源(注意，假如TextReader中持有stream或其他

对象，当TextReader执行了Dispose方法时，stream对象也被回收了)

*4:int Peek()方法

 这个方法主要是寻找当前char的下个 char,当返回值是-1时，表示下个 char已经是最后一个位置的char了

*5：int Read()方法：

 同样，read()方法是读取下一个char, 但是和peek方法不同，read()方法使指针指向下个字符，但是peek

 还是指向原来那个字符

*6：int Read(Char[] buffer,int index,int count)方法：

 这个重载read方法和上一章Stream的read方法有点神似，区别是一个参数是byte数组，而这个是char数组，

（注意:是通过reader 将数据数据读入buffer数组）,index:从哪个位置开始，count:读取char数量

*7: int ReadBlock(Char[] buffer,int index,int count)方法：

 和Read方法基本一致，区别是从效率上来说ReadBlock更高点，而且ReadBlock并非属于线程安全，使用时要注意

*8：virtual string ReadLine() 方法：

  顾名思义，这个方法将读取每一行的数据并返回当前行的字符的字符串

*9：virtual string ReadToEnd()方法：

  包含从当前位置到 TextReader 的结尾的所有字符的字符串 

 

下面的例子将是对上述方法的温故而知新：

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
 string text = "abc\nabc";


            using (TextReader reader = new StringReader(text))
            {
                while (reader.Peek() != -1)
                {
                    Console.WriteLine("Peek = {0}", (char)reader.Peek());
                    Console.WriteLine("Read = {0}", (char)reader.Read());
                }
                reader.Close();
            }

            using (TextReader reader = new StringReader(text))
            {
                char[] charBuffer = new char[3];
                int data = reader.ReadBlock(charBuffer, 0, 3);
                for (int i = 0; i < charBuffer.Length; i++)
                {
                    Console.WriteLine("通过readBlock读出的数据：{0}", charBuffer[i]);
                }
                reader.Close();
            }

            using (TextReader reader = new StringReader(text))
            {
                string lineData = reader.ReadLine();
                Console.WriteLine("第一行的数据为:{0}", lineData);
                reader.Close();
            }

            using (TextReader reader = new StringReader(text))
            {
                string allData = reader.ReadToEnd();
                Console.WriteLine("全部的数据为:{0}", allData);
                reader.Close();
            }

            Console.ReadLine();
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

输出结果：

![img](https://pic002.cnblogs.com/images/2012/132191/2012031822243252.png)

 

StreamReader登场

终于今天的主角登场了，在前面做了那么多铺垫后在学习它会事半功倍

 

从StreamReader想到多态

在说明StreamReader之前还有一件事要提起，那就是多态, 多态到底是什么概念呢？聪明的你肯定会想到多态不就是子类的多种

表现形式？不错,但这还是不是完全的，不仅如此，现实世界中，父亲帮儿子买了套房子，但是他没有在房产证上写儿子的名字，

所以这个房子儿子和父亲能共同使用，儿子能根据自己的爱好装修房子，父亲也能住在儿子装修好的房子内，也就是说父类能够

灵活使用子类的功能，更科学的一点就是子类的指针允许（赋值给）父类指针。上述例子中

```
TextReader reader = new StringReader(text)
```

 这个就是个多态的经典例子大家不妨深刻理解下这个重要的概念

 

简单介绍下Encoding编码

为什么要简单介绍Encoding编码？因为Encoding编码在Stream和相关类中起的非常重要的作用，

由于Encoding类会在后续章节详细解释，现在我就先介绍下 Encoding类一些重要编码 

 ![img](https://pic002.cnblogs.com/images/2012/132191/2012031822345252.png)

以上便是Encoding类中一些特定的编码，大家先了解即可，但使用Default时有点必须注意，如果你用不一样编码的机器的时候，

注意服务器或者其他操作系统的编码规则，举个例子，如果你在一个中文操作系统进行编码，但是发布到了一个其他语言的操作

系统上那就会出问题了这时候你必须选择一个通用编码

StreamReader 类的定义和作用

StreamReader 的定义：实现一个 [TextReader](http://msdn.microsoft.com/zh-cn/library/system.io.textreader.aspx)，使其以一种特定的编码从字节流中读取字符。

在对于流的操作中，StreamReader对于流的读取方面非常重要,为什么这么说呢，我们常用的文件的复制，移动，上传，下载，压缩，保存，

远程FTP文件的读取，甚至于HttpResponse等等只要是于流相关的任何派生类StreamReader 都能够轻松处理，当然，大家甚至可以自定义

相关的派生类去实现复杂的序列化。在实际项目，我们可能碰到过许多上述的情况，有时乱码的问题会让我们发狂，但是只要深刻去理解基础的话，

我相信大家都能找到适合自己的解决方法

StreamReader 类的常用属性及方法

其实StreamReader的一些方法已经在其父类TextReader中说的很仔细了，但是个人觉得构造函数和属性才是重点.

**首先上构造函数**：

*1: StreamReader(Stream stream)

 将stream作为一个参数 放入StreamReader，这样的话StreamReader可以对该stream进行读取操作,Stream对象可以非常广泛，包括所有Stream的派生类对象

*2: StreamReader(string string, Encoding encoding)

 这里的string对象不是简单的字符串而是具体文件的地址,然后根据用户选择编码去读取流中的数据

*3: StreamReader(string string，bool detectEncodingFromByteOrderMarks)    

有时候我们希望程序自动判断用何种编码去读取，这时候detectEncodingFromByteOrderMarks这个参数就能起作用了，当设置为true的 时候数通过查看流的前三个字节

来检测编码。如果文件以适当的字节顺序标记开头，该参数自动识别 UTF-8、Little-Endian Unicode 和 Big-Endian Unicode 文本，当为false 时，方法会去使用用户提供

的编码

*4: StreamReader(string string, Encoding encoding, bool detectEncodingFromByteOrderMarks,int bufferSize)     

这个放提供了4个参数的重载，前3个我们都已经了解，最后个是缓冲区大小的设置，

*StreamReader 还有其他的一些构造函数，都是上述4个的扩充，所以本例就取上述的4个构造函数来说明 

**属性****:**

1:BaseStream

 大家对于前一章流的操作应该没什么问题，我就直切主题，最简单的理解就是将上述构造函数的流对象在重新取出来进行一系列的操作，

 可是如果构造函数中是路径怎么办，一样，构造函数能够将路径文件转化成流对象

```
FileStream fs = new FileStream ( "D:\\TextReader.txt", FileMode.Open , FileAccess.Read ) ; 
StreamReader sr= new StreamReader ( fs ) ; 
//本例中的BaseStream就是FileStream
sr.BaseStream.Seek (0 , SeekOrigin.Begin ) ;
 
```

 2:CurrentEncoding:

获取当前StreamReader的Encoding

3:EndOfStream:

判断StreamReader是否已经处于当前流的末尾

 

 

最后用FileStream的示例来温故下StreamReader

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
static void Main(string[] args)
        {
           
            //文件地址
            string txtFilePath="D:\\TextReader.txt";
            //定义char数组
            char[] charBuffer2 = new char[3];

            //利用FileStream类将文件文本数据变成流然后放入StreamReader构造函数中
            using(FileStream stream = File.OpenRead(txtFilePath))
            {
                using (StreamReader reader = new StreamReader(stream))
                {
                    //StreamReader.Read()方法
                    DisplayResultStringByUsingRead(reader);
                }
            }

            using (FileStream stream = File.OpenRead(txtFilePath))
            {
                //使用Encoding.ASCII来尝试下
                using (StreamReader reader = new StreamReader(stream,Encoding.ASCII,false))
                {
                    //StreamReader.ReadBlock()方法
                    DisplayResultStringByUsingReadBlock(reader);
                }
            }

            //尝试用文件定位直接得到StreamReader，顺便使用 Encoding.Default
            using(StreamReader reader = new StreamReader(txtFilePath, Encoding.Default,false,123))
            {
               //StreamReader.ReadLine()方法
              DisplayResultStringByUsingReadLine(reader);
            }

            //也可以通过File.OpenText方法直接获取到StreamReader对象
            using (StreamReader reader = File.OpenText(txtFilePath)) 
            {
                //StreamReader.ReadLine()方法
                DisplayResultStringByUsingReadLine(reader);
            }

            Console.ReadLine();
        }

        /// <summary>
        /// 使用StreamReader.Read()方法
        /// </summary>
        /// <param name="reader"></param>
        public static  void DisplayResultStringByUsingRead(StreamReader reader) 
        {
            int readChar = 0;
            string result = string.Empty;
            while ((readChar=reader.Read()) != -1) 
            {
                result += (char)readChar;
            }
            Console.WriteLine("使用StreamReader.Read()方法得到Text文件中的数据为 : {0}", result);
        }

        /// <summary>
        /// 使用StreamReader.ReadBlock()方法
        /// </summary>
        /// <param name="reader"></param>
        public static void DisplayResultStringByUsingReadBlock(StreamReader reader)
        {
            char[] charBuffer = new char[10];
            string result = string.Empty;
            reader.ReadBlock(charBuffer,0,10);
            for (int i = 0; i < charBuffer.Length; i++)
            {
                result += charBuffer[i];
            }
            Console.WriteLine("使用StreamReader.ReadBlock()方法得到Text文件中前10个数据为 : {0}", result);
        }


        /// <summary>
        /// 使用StreamReader.ReadLine()方法
        /// </summary>
        /// <param name="reader"></param>
        public static void DisplayResultStringByUsingReadLine(StreamReader reader)
        {
            int i=1;
            string resultString = string.Empty;
            while ((resultString=reader.ReadLine() )!= null)
            {
                Console.WriteLine("使用StreamReader.Read()方法得到Text文件中第{1}行的数据为 : {0}", resultString, i);
                i++;
            }
            
        }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

 输出结果：

 ![img](https://pic002.cnblogs.com/images/2012/132191/2012031823524140.png)

本章总结

本章详细介绍了TextReader和StreamReader的定义概念和一些注意事项，希望大家能够在本文中温故而知新，下章会简单介绍下TextWriter和StreamWriter